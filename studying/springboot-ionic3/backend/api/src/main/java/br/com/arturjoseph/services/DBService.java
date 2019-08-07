package br.com.arturjoseph.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import br.com.arturjoseph.domain.enums.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.arturjoseph.domain.Categoria;
import br.com.arturjoseph.domain.Cidade;
import br.com.arturjoseph.domain.Cliente;
import br.com.arturjoseph.domain.Endereco;
import br.com.arturjoseph.domain.Estado;
import br.com.arturjoseph.domain.ItemPedido;
import br.com.arturjoseph.domain.Pagamento;
import br.com.arturjoseph.domain.PagamentoComBoleto;
import br.com.arturjoseph.domain.PagamentoComCartao;
import br.com.arturjoseph.domain.Pedido;
import br.com.arturjoseph.domain.Produto;
import br.com.arturjoseph.domain.enums.EstadoPagamento;
import br.com.arturjoseph.domain.enums.TipoCliente;
import br.com.arturjoseph.repositories.CategoriaRepository;
import br.com.arturjoseph.repositories.CidadeRepository;
import br.com.arturjoseph.repositories.ClienteRepository;
import br.com.arturjoseph.repositories.EnderecoRepository;
import br.com.arturjoseph.repositories.EstadoRepository;
import br.com.arturjoseph.repositories.ItemPedidoRepository;
import br.com.arturjoseph.repositories.PagamentoRepository;
import br.com.arturjoseph.repositories.PedidoRepository;
import br.com.arturjoseph.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository repoCategoria;
	@Autowired
	private ProdutoRepository repoProduto;
	@Autowired
	private CidadeRepository repoCidade;
	@Autowired
	private EstadoRepository repoEstado;
	@Autowired
	private ClienteRepository repoCliente;
	@Autowired
	private EnderecoRepository repoEndereco;
	@Autowired
	private PedidoRepository repoPedido;
	@Autowired
	private PagamentoRepository repoPagamento;
	@Autowired
	private ItemPedidoRepository repoItemPedido;
	@Autowired
	private BCryptPasswordEncoder pe;

	public void instantiateTestDatabase() {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônico");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Mobile");

		Produto p1 = new Produto(null, "Computador", new BigDecimal("2000.00"));
		Produto p2 = new Produto(null, "Impressora", new BigDecimal("800.00"));
		Produto p3 = new Produto(null, "Mouse", new BigDecimal("80.00"));
		Produto p4 = new Produto(null, "Mesa de escritório", new BigDecimal("300.00"));
		Produto p5 = new Produto(null, "Toalha", new BigDecimal("50.00"));
		Produto p6 = new Produto(null, "Colcha", new BigDecimal("200.00"));
		Produto p7 = new Produto(null, "TV true color", new BigDecimal("1200.00"));
		Produto p8 = new Produto(null, "Roçadeira", new BigDecimal("800.00"));
		Produto p9 = new Produto(null, "Abajour", new BigDecimal("100.00"));
		Produto p10 = new Produto(null, "Pendente", new BigDecimal("180.00"));
		Produto p11 = new Produto(null, "Shampoo", new BigDecimal("90.00"));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		repoCategoria.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		repoProduto.saveAll(Arrays.asList(p1, p2, p3));
		repoProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		repoEstado.saveAll(Arrays.asList(est1, est2));
		repoCidade.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Artur Neto", "arturjoseph@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA, pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		Cliente cli2 = new Cliente(null, "Cleide França", "group.nazareh@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli2.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli2, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli1.getEnderecos().addAll(Arrays.asList(e2));

		repoCliente.saveAll((Arrays.asList(cli1, cli2)));
		repoEndereco.saveAll((Arrays.asList(e1, e2)));

		Pedido ped1 = new Pedido(null, LocalDateTime.of(2017, 9, 30, 10, 32), cli1, e1);
		Pedido ped2 = new Pedido(null, LocalDateTime.of(2017, 10, 10, 19, 35), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, LocalDate.of(2017, 10, 20),
				null);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);

		repoPedido.saveAll(Arrays.asList(ped1, ped2));
		repoPagamento.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, new BigDecimal("0.00"), 1, new BigDecimal("2000.00"));
		ItemPedido ip2 = new ItemPedido(ped1, p3, new BigDecimal("0.00"), 2, new BigDecimal("80.00"));
		ItemPedido ip3 = new ItemPedido(ped2, p2, new BigDecimal("100.00"), 1, new BigDecimal("800.00"));

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		repoItemPedido.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
