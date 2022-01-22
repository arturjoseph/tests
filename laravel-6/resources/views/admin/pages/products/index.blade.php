@extends('admin.layouts.app')
@section('title','Produtos')
@section('content')
    <h1>Exibindo os produtos</h1>
    <a href="{{route('products.create')}}" class="btn btn-primary">Novo produto</a>
    <hr>
    <form action="{{route('products.search')}}" method="post" class="form form-inline">
        @csrf
        <input type="search" name="search" id="search" class="form-control">
        <button type="submit" class="btn btn-info">Pesquisar</button>
    </form>
           <table class="table">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                @foreach ($products as $product )
                    <tr>
                        <td>{{ $product->name }}</td>
                        <td>{{ $product->price }}</td>
                        <td width="100">
                            <a href="{{route('products.show',$product->id)}}">Detalhes</a>
                            <a href="{{route('products.edit',$product->id)}}">Editar</a>
                        </td>
                    </tr>
                @endforeach
            </tbody>

        </table>
        {!! $products->links() !!}
@endsection

