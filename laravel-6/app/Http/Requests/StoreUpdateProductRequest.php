<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreUpdateProductRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'name'=> 'required|min:3|max:255|unique:products',
            'description'=> 'required|min:3|max:255',
            'price'=> 'required',
            'image'=> 'nullable|image',
        ];
    }

    public function messages()
    {
        return[
            'name.required'=>'O campo nome é obrigatório!',
            'name.min'=>'O campo nome deve conter no mínimo 3 caracteres!',
            'description.required'=>'O campo descrição é obrigatório!',
            'description.min'=>'O campo descrição deve conter no mínimo 3 caracteres!',
            'price.required'=>'O campo preço é obrigatório!',
        ];
    }
}
