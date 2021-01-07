package br.com.alura.investimento;

interface Resposta {
	
	void responde(Requisicao req, Conta conta);
	void setProxima(Resposta resposta);
}
