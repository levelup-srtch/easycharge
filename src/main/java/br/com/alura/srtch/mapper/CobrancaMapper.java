package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.model.*;
import br.com.alura.srtch.repository.CobrancaRepository;
import br.com.alura.srtch.repository.DividaRepository;

import java.util.Locale;

public class CobrancaMapper {

    public Cobranca cadastrar(CobrancaForm form, CobrancaRepository cobrancaRepository, Divida divida) {
        MeioDeContato meioDeContato = MeioDeContato.TELEFONE;
        if (form.getMeioDeContato().name().equals("EMAIL")) {
            meioDeContato = MeioDeContato.EMAIL;
        }

        TipoAgente tipoAgente = TipoAgente.EXTERNO;
        if (form.getTipoDeAgente().name().equals("INTERNO")) {
            tipoAgente = TipoAgente.INTERNO;
        }

        Cobranca cobranca = new Cobranca(form.getDataDeRealizacao(), meioDeContato,
                form.getAgente(), tipoAgente, form.getComentarioDoAgente(), divida);
        TipoAcordo tipoAcordo = null;
        if (form.getTipoDeAcordo().name().equals("PROMESSA")) {
            tipoAcordo = TipoAcordo.PROMESSA;
        } else if (form.getTipoDeAcordo().name().equals("PARCELAMENTO")){
            tipoAcordo = TipoAcordo.PARCELAMENTO;
        }
        cobranca.setTipoDeAcordo(tipoAcordo);
        cobranca.setAcordo(form.getAcordo());
        cobranca.setDataDePromessaDePagamento(form.getDataDePromessaDePagamento());
        cobranca.setNumeroDeParcelas(form.getNumeroDeParcelas());

        if (cobrancaRepository.somaDeCobrancasDaDivida(form.getIdDivida()) == 3) {
            divida.setStatus(StatusDivida.RECUPERACAO_JUDICIAL);
        }

        return cobranca;
    }

}
