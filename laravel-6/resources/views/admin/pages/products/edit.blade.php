@extends('admin.layouts.app')
@section('title','Edição Produto')
@section('content')
    <h1>Editar produto {{ $id }}</h1>
    <form action="{{route('products.update', $id)}}" method="post">
        @method('PUT')
        @csrf
        <input type="text" name="nome" placeholder="Maria">
        <input type="text" name="descricao" placeholder="Sou da Bahia">
        <button type="submit">Salvar</button>
    </form>
@endsection
