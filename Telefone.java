package contatos;
import java.util.List;
public class Telefone {
	private String DDD;
    private String numero;
    List<Telefone> telefones;
    public Telefone() {
    	
    }
    
    public Telefone(String DDD, String numero) {
    	this.DDD = DDD;
    	this.numero =  numero;
    }
    
    public void setNumero(String numero) {
    	this.numero = numero;
    }
    
    public String getNumero() {
    	return numero;
    }
    
    public String getDDD() {
    	return DDD;
    }
    
    public void setDDD(String DDD) {
    	this.DDD = DDD;
    }
    public void setTelefones(List<Telefone> telefones) {
    	this.telefones = telefones;
    }
    public List<Telefone> telefones(){
    	return telefones;
    }
    public Telefone adicionaTelefones(Telefone telefones ) {
    	telefones.getNumero();
    	telefones.getDDD();
    	return telefones;
    	
    }
    
}
