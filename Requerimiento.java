package patrones;

import java.util.Hashtable;

public class Requerimiento extends Hashtable implements Comparable<Requerimiento>{
	private int statusCod;  //0(pendiente),1(aprobado),2(ejecucion),3(concluido)
	
	public Requerimiento(String reqID){
		setStatusCod(0);
                this.put("requestID", reqID.toString());
	}

	public int getStatusCod() {
		return statusCod;
	}

	public void setStatusCod(int statusCod) {
		this.statusCod = statusCod;
	}
	
	@SuppressWarnings("unchecked")
	public void toAprobado(){
		this.put("status", "Aprobado");
		setStatusCod(1);
	}
	@SuppressWarnings("unchecked")
	public void toEjecucion(){
		this.put("status", "En Ejecucion");
		setStatusCod(2);
	}
	@SuppressWarnings("unchecked")
	public void toConcluido(){
		this.put("status", "Concluido");
		setStatusCod(3);
	}

    @Override
    public int compareTo(Requerimiento o) {
        if(Integer.valueOf(this.get("requestID").toString()) < Integer.valueOf(o.get("requestID").toString())){    
            return -1;
        }else if(Integer.valueOf(this.get("requestID").toString()) > Integer.valueOf(o.get("requestID").toString())){
            return 1;
        }else{
            return 0;
        }
    }

}
