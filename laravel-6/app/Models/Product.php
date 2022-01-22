<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Product extends Model
{
    protected $fillable = ['name','description','price','image'];

    public function search($search = null)
    {
        $results = $this->where(function($query) use($search){
            if($search){
                $query->where('name','LIKE',"%$search%");
            }
        })->paginate();
        return $results;
    }
}
