package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.StatusDivida;
import br.com.alura.srtch.repository.ClienteRepository;

public class DividaMapper {

    public Divida cadastrar(DividaForm form, ClienteRepository repository) {
        Cliente cliente = repository.getById(form.getIdCliente());

        Divida divida = new Divida(form.getValor(), form.getStatus(), cliente);
        if (form.getDataDeQuitacao() != null) {
            divida.setDataDeQuitacao(form.getDataDeQuitacao());
        }
        if (form.getDescricaoDeQuitacao() != null) {
            divida.setDescricaoDeQuitacao(form.getDescricaoDeQuitacao());
        }
        if (form.getStatus().equals("QUITADA")) {
            divida.setStatus(StatusDivida.QUITADA);
        }
        return divida;
    }

}
