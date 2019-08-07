package br.com.arturjoseph.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arturjoseph.domain.ItemPedido;
import br.com.arturjoseph.domain.PagamentoComBoleto;
import br.com.arturjoseph.domain.Pedido;
import br.com.arturjoseph.domain.enums.EstadoPagamento;
import br.com.arturjoseph.repositories.ItemPedidoRepository;
import br.com.arturjoseph.repositories.PagamentoRepository;
import br.com.arturjoseph.repositories.PedidoRepository;
import br.com.arturjoseph.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repoPedido;
	@Autowired
	private PagamentoRepository repoPagamento;
	@Autowired
	private ItemPedidoRepository repoItemPedido;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EmailService emailService;

	public Pedido find(Integer id) {
		Optional<Pedido> pedido = repoPedido.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(LocalDateTime.now());
		pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if (pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante().toLocalDate());
		}
		pedido = repoPedido.save(pedido);
		repoPagamento.save(pedido.getPagamento());
		for (ItemPedido ip : pedido.getItens()) {
			ip.setDesconto(new BigDecimal("0.00"));
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(pedido);
		}
		repoItemPedido.saveAll(pedido.getItens());
		emailService.sendOrderConfirmationHtmlEmail(pedido);
		return pedido;
	}
}
