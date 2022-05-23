package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length=10)
  private Long id;

  @Column(nullable=false, length=10)
  private BigDecimal renda;

  private BigDecimal limiteDivida;

  @Embedded
  private DadosPessoais dadosPessoais;

  @Embedded
  private Endereco endereco;

  @Enumerated(EnumType.STRING)
  @JoinColumn(nullable = false)
  private StatusCliente status = StatusCliente.ATIVO;

  public Cliente() {
  }

  public Cliente(BigDecimal renda, DadosPessoais dadosPessoais, Endereco endereco, StatusCliente status) {
    this.renda = renda;
    this.dadosPessoais = dadosPessoais;
    this.endereco = endereco;
    this.status = status;
  }

  public void alteraStatus(){
    if(this.status.equals(StatusCliente.SUSPENSO)){
      status = StatusCliente.ATIVO;
    }else{
      status = StatusCliente.SUSPENSO;
    }
  }

  public void setLimiteDeDivida(){
      this.limiteDivida = this.renda.multiply(BigDecimal.valueOf(12));
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getRenda() {
    return renda;
  }

  public void setRenda(BigDecimal renda) {
    this.renda = renda;
  }

  public BigDecimal getLimiteDivida() {
    return limiteDivida;
  }

  public DadosPessoais getDadosPessoais() {
    return dadosPessoais;
  }

  public void setDadosPessoais(DadosPessoais dadosPessoais) {
    this.dadosPessoais = dadosPessoais;
  }

  public String getNome(){
    return dadosPessoais.getNome();
  }

  public void setNome(String nome){
    this.dadosPessoais.setNome(nome);
  }

  public String getCpf(){
    return dadosPessoais.getCpf();
  }

  public String getTelefone(){
    return dadosPessoais.getTelefone();
  }

  public void setTelefone(String telefone){
    this.dadosPessoais.setTelefone(telefone);
  }

  public String getEmail(){
    return dadosPessoais.getEmail();
  }

  public void setEmail(String email){
    this.dadosPessoais.setEmail(email);
  }

  public String getProfissao(){
    return dadosPessoais.getProfissao();
  }

  public void setProfissao(String profissao) {
    this.dadosPessoais.setProfissao(profissao);
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getRua() {
    return endereco.getRua();
  }

  public void setRua(String rua){
    this.endereco.setRua(rua);
  }

  public String getNumero() {
    return endereco.getNumero();
  }

  public void setNumero(String numero){
    this.endereco.setNumero(numero);
  }

  public String getComplemento() {
    return endereco.getComplemento();
  }

  public void setComplemento(String complemento){
    this.endereco.setComplemento(complemento);
  }

  public String getBairro() {
    return endereco.getBairro();
  }

  public void setBairro(String bairro){
    this.endereco.setBairro(bairro);
  }

  public String getCidade() {
    return endereco.getCidade();
  }

  public void setCidade(String cidade){
    this.endereco.setCidade(cidade);
  }

  public String getEstado() {
    return endereco.getEstado();
  }

  public void setEstado(String estado){
    this.endereco.setEstado(estado);
  }

  public StatusCliente getStatus() {
    return status;
  }

  public void setStatus(StatusCliente status) {
    this.status = status;
  }


  @Override
  public String toString() {
    return "Cliente{" +
            "renda=" + renda +
            ", dadosPessoais=" + dadosPessoais +
            ", endereco=" + endereco +
            ", status=" + status +
            '}';
  }
}
