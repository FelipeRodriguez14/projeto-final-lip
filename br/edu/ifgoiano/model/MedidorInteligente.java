package br.edu.ifgoiano.model;

import br.edu.ifgoiano.utils.exceptions.TensaoException;
import br.edu.ifgoiano.utils.exceptions.ValorPositivoException;

public class MedidorInteligente{
  private String macAddress;
  private double consumoAcumuladoKWh;
  private double injecaoAcumuladaKWh;
  private double tensaoRede;

  public MedidorInteligente(String mac, double tensao){
    this.macAddress = mac;
    this.tensaoRede = tensao;
  }

  // Atende a regra número 5 do roteiro.
  public MedidorInteligente(String mac){
    this(mac, 220);
  }

  public void registrarConsumo(double kwh){
    if(this.validarValoresPositivos(kwh)){

    }
  }

  public void registrarInjecaoSolar(double kwh){
    if(this.validarValoresPositivos(kwh)){
      
    }
  }

  public void calcularSaldoConsumoLiquido(){
    
  }

  public String getMacAddress() {
    return macAddress;
  }

  public double getConsumoAcumuladoKWh() {
    return consumoAcumuladoKWh;
  }

  public void setConsumoAcumuladoKWh(double consumoAcumuladoKWh) {
    this.consumoAcumuladoKWh = consumoAcumuladoKWh;
  }
  
  public double getInjecaoAcumuladaKWh() {
    return injecaoAcumuladaKWh;
  }

  public void setInjecaoAcumuladaKWh(double injecaoAcumuladaKWh) {
    this.injecaoAcumuladaKWh = injecaoAcumuladaKWh;
  }

  public double getTensaoRede() {
    return tensaoRede;
  }

  public void setTensaoRede(double tensaoRede) {
    if(this.validarTensao(tensaoRede)){
      this.tensaoRede = tensaoRede;
    }
    
  }

  private boolean validarValoresPositivos(double valor){
    if(valor <= 0){
      String msg = "VALOR INVÁLIDO. SOMENTE VALORES POSITIVOS SÃO ACEITOS.";
      // Atende a regra número 4 do roteiro.
      System.out.println(msg);
      throw new ValorPositivoException(msg);
    } else{
      return true;
    }

  }

  private boolean validarTensao(double tensao){
    if(tensao < 90 || tensao > 250){
      this.tensaoRede = 0;
      String msg = "TENSÃO FORA DA FAIXA SEGURANÇA ! \n" + "DISPOSITIVO: " + this.getMacAddress() +
      "ALIMENTAÇÃO INTERROMPIDA. TENSÃO ATUAL: " + this.getTensaoRede();
      // Atende a regra número 4 do roteiro.
      System.out.println(msg);
      throw new TensaoException(msg);
    } else{
      return true;
    }
  }

}