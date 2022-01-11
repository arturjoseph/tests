@extends('admin.layouts.app')
@section('title','Produtos')
@section('content')
    <h1>Exibindo os produtos</h1>
    <a href="{{route('products.create')}}">Novo produto</a>
@endsection

