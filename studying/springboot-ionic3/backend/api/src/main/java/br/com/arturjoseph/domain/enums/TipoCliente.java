package br.com.arturjoseph.domain.enums;

public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoal Física"), PESSOA_JURIDICA(2, "Pessoal Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCod() {
		return cod;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente tipo : TipoCliente.values()) {
			if (cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
