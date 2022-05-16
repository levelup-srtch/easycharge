package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.model.*;
import br.com.alura.srtch.repository.CobrancaRepository;
import br.com.alura.srtch.repository.DividaRepository;

public class CobrancaMapper {

    public Cobranca cadastrar(CobrancaForm form, CobrancaRepository cobrancaRepository, DividaRepository dividaRepository) {
        Divida divida = dividaRepository.getById(form.getIdDivida());
        MeioDeContato meioDeContato;
        if (form.getMeioDeContato().name().equals("EMAIL")){
            meioDeContato = MeioDeContato.EMAIL;
        }else {
            meioDeContato = MeioDeContato.TELEFONE;
        }
        TipoAgente tipoAgente;
        if(form.getTipoDeAgente().name().equals("INTERNO")){
            tipoAgente = TipoAgente.INTERNO;
        }else {
            tipoAgente = TipoAgente.EXTERNO;
        }

        Cobranca cobranca = new Cobranca(form.getDataDeRealizacao(), meioDeContato,
                form.getAgente(), tipoAgente, form.getComentarioDoAgente(), divida);
        if(form.getTipoDeAcordo() != null){
            TipoAcordo tipoAcordo;
            if(form.getTipoDeAcordo().name().equals("PROMESSA")){
                tipoAcordo = TipoAcordo.PROMESSA;
            } else {
                tipoAcordo = TipoAcordo.PARCELAMENTO;
            }
            cobranca.setTipoDeAcordo(tipoAcordo);
        }
        if (form.getAcordo() != null){
            cobranca.setAcordo(form.getAcordo());
        }
        if (form.getDataDePromessaDePagamento() != null){
            cobranca.setDataDePromessaDePagamento(form.getDataDePromessaDePagamento());
        }
        if (form.getNumeroDeParcelas() != null){
            cobranca.setNumeroDeParcelas(form.getNumeroDeParcelas());
        }
        if (cobrancaRepository.somaDeCobrancasDaDivida(form.getIdDivida()) == 3){
            divida.setStatus(StatusDivida.RECUPERACAO_JUDICIAL);
        }

        return cobranca;
    }

}
