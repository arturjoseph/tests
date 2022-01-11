@extends('admin.layouts.app')
@section('title','Cadastro de Produto')
@section('content')
    <h1>Cadastrar novo produto</h1>
        @if ($errors->any())
            <ul>
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        @endif

    <form action="{{route('products.store')}}" method="post" enctype="multipart/form-data">
        @csrf
        <input type="text" name="nome" placeholder="Maria" value="{{ old('nome') }}">
        <input type="text" name="descricao" placeholder="Sou da Bahia" value="{{ old('descricao') }}">
        <input type="file" name="foto" >
        <button type="submit">Salvar</button>
    </form>
@endsection
