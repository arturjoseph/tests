@extends('admin.layouts.app')
@section('title','Cadastro de Produto')
@section('content')
    <h1>Cadastrar novo produto</h1>
        @include('admin.includes.alerts')

    <form action="{{route('products.store')}}" method="post" enctype="multipart/form-data" class="form">
        @csrf
        <div class="form-group">
            <input class="form-control" type="text" name="name" placeholder="Maria" value="{{ old('name') }}">
        </div>
        <div class="form-group">
            <input class="form-control" type="text" name="description" placeholder="Sou da Bahia" value="{{ old('description') }}">
        </div>
        <div class="form-group">
            <input class="form-control" type="text" name="price" placeholder="R$10,00" value="{{ old('price') }}">
        </div>
        <div class="form-group">
            <input class="form-control" type="file" name="image" >
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success">Salvar</button>
        </div>

    </form>
@endsection
