import '../../modelos/receita.dart';
import 'package:flutter/material.dart';

class Detalhes extends StatelessWidget{

  final Receita receita;
  Detalhes({Key key, @required this.receita}) : super(key: key);


  @override
  Widget build(BuildContext context) {
    return _contruirDetallhes();
  }

  Widget _contruirDetallhes(){
    return Scaffold(
      body: ListView(
        children: <Widget>[
          _contruirImagemDetalhes(receita.foto),
          _contruirTituloDetalhes(receita.titulo),
          _contruirLinhaIconeDetalhes('${receita.porcoes} porções', receita.tempoPreparo),
          _contruirSubtituloDetalhes('Ingredientes'),
          _contruirTextoDetalhes(receita.ingredientes),
          _contruirSubtituloDetalhes('Modo de Preparo'),
          _contruirTextoDetalhes(receita.modoPreparo),
        ],
      ),
      appBar: _construirAppBar("Detalhes da receita")
    );
  }

  Widget _contruirLinhaIconeDetalhes(rendimento, tempo_preparo){
    return Row(
      children: <Widget>[
        _contruirColunaIconeDetalhes(Icons.restaurant, rendimento),
        _contruirColunaIconeDetalhes(Icons.timer, tempo_preparo)
      ],
    );
  }

  Widget _contruirColunaIconeDetalhes(icone, texto){
    return Expanded(
      child: Column(
        children: <Widget>[
          Icon(icone, color: Colors.deepOrange),
          Text(texto, style: TextStyle(color: Colors.deepOrange, fontWeight: FontWeight.bold))
        ],
      ) 
    );
  }

  Widget _contruirSubtituloDetalhes(subtitulo){
    return Center(child: Text(subtitulo, style: TextStyle(fontSize: 20)));
  }

  Widget _contruirTextoDetalhes(texto){
    return Container(
      padding: EdgeInsets.all(16),
      child: Text(texto)
    );
  }

  Widget _construirAppBar(String titulo) {
    return AppBar(title: Text(titulo));
  }

  Widget _contruirImagemDetalhes(imagem) {
    return Image.asset(imagem);
  }

  Widget _contruirTituloDetalhes(titulo){
    return Center(child: Text(titulo, style: TextStyle( color: Colors.deepOrange, fontSize: 30)));
  }
}