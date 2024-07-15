<?php

namespace ScreenMatch\Model;
use ScreenMatch\Exception\NotaInvalidaException;

trait ComAvaliacao
{
    private array $notas = [];

    /**
     * @throws NotaInvalidaException Se a nota for menor que 1 ou maior do que 10
     */
    public function avalia(float $nota): void
    {
        if ($nota < 1 || $nota > 10) {
            throw new NotaInvalidaException();
        }
        $this->notas[] = $nota;
    }

    public function media(): float
    {
        $somaNotas = array_sum($this->notas);
        $quantidadeNotas = count($this->notas);

        return $somaNotas / $quantidadeNotas;
    }
}
