package danidevs.contabancaria.controller;

import org.springframework.web.bind.annotation.*;

import danidevs.contabancaria.model.Conta;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private Conta conta;

    public ContaController() {

        conta = new Conta();
        conta.setId(1);
        conta.setTitular("Danidevs");
        conta.setSaldo(1000.0);
    }

    @GetMapping("/{id}")
    public Conta getConta(@PathVariable int id) {
        if (id == conta.getId()) {
            return conta;
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }

    @PostMapping("/{id}/depositar")
    public void depositar(@PathVariable int id, @RequestParam double valor) {
        if (id == conta.getId()) {
            conta.setSaldo(conta.getSaldo() + valor);
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }

    @PostMapping("/{id}/sacar")
    public void sacar(@PathVariable int id, @RequestParam double valor) {
        if (id == conta.getId()) {
            double novoSaldo = conta.getSaldo() - valor;
            if (novoSaldo >= 0) {
                conta.setSaldo(novoSaldo);
            } else {
                throw new RuntimeException("Saldo insuficiente");
            }
        }
    }

    @GetMapping("/{id}/saldo")
    public void getSaldo(@PathVariable int id) {
        if (id == conta.getId()) {
            return;
        }
    }
}
