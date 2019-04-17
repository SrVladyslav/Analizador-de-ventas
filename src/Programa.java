import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Programa {
	   public static void main(String[] args) throws IOException {
		   //declaro el archivo en el que escribire el resultado
		   FileWriter csvWriter = new FileWriter("First10BestSalesV2.csv");  
		   //declaro la primera fila de la cabecera de donde escribbire el titulo
		   csvWriter.append("Day");  
		   csvWriter.append(",");  
		   csvWriter.append("       Item ID");  
		   csvWriter.append(",");  
		   csvWriter.append("              Color ID");  
		   csvWriter.append(",");  
		   csvWriter.append("                      Size ID");
		   csvWriter.append(",");  
		   csvWriter.append("                       Sales ID");
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days71:");
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days72:");  
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days73:");  
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days74:");
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days75:");
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days76:");
		   csvWriter.append(",");  
		   csvWriter.append("       stock_replenishment_days77:");
		   csvWriter.append("\n");
		  //declaro los readers para leer los archivos dados posteriormente 
	      BufferedReader br = null;
	      BufferedReader br2 = null;
	      LinkedList<Elemento[]> items = new LinkedList<Elemento[]>();
	      Elemento[] lideres = new Elemento[10];//los lideres de cada dia que seran el top 10
	      Elemento nulo = new Elemento(0,0,0,0,0,0);
	      lideres[0] = nulo;
	      lideres[1] = nulo;
	      lideres[2] = nulo;
	      lideres[3] = nulo;
	      lideres[4] = nulo;
	      lideres[5] = nulo;
	      lideres[6] = nulo;
	      lideres[7] = nulo;
	      lideres[8] = nulo;
	      lideres[9] = nulo;
	      items.add(lideres);
	      int diaActual = 0;
	      
	      try {
	         
	         br =new BufferedReader(new FileReader("src/statistica.csv"));
	         String line = br.readLine();
	         line = br.readLine();
	         int i = 0;
	        
	         
	         //leo el archivo primero y saco los 10 mejores de cada tanda
	         while (null!=line) {
	            String [] fields = line.trim().split(",");
	            	Elemento e = new Elemento(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]),
	            			Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),Integer.parseInt(fields[4]),
	            			Integer.parseInt(fields[5]));
	            	if(lideres[9].sales <= e.sales){
	            	     lideres[0] = lideres[1];
	            	     lideres[1] = lideres[2];
	            	     lideres[2] = lideres[3];
	            	     lideres[3] = lideres[4];
	            	     lideres[4] = lideres[5];
	            	     lideres[5] = lideres[6];
	            	     lideres[6] = lideres[7];
	            	     lideres[7] = lideres[8];
	            	     lideres[8] = lideres[9];
	            	     lideres[9] = e;
	            	}
	            	if(diaActual != e.date_number) {
	            		//escribo en el archivo de salida los resultados
	            		diaActual = e.date_number;
	            		System.out.println("DIA: "+(e.date_number));
	            		csvWriter.append(String.join(",", "DIA: "+(e.date_number)));
	     		       	csvWriter.append("\n");
	            		System.out.println("      >>><1>: "+lideres[9].toString());
	            		csvWriter.append(String.join(",", lideres[9].toString()));
	     		       	csvWriter.append("\n");
		   	        	System.out.println("      >>><2>" + lideres[8].toString());
		   	        	csvWriter.append(String.join(",", lideres[8].toString()));
	     		       	csvWriter.append("\n");
		   	        	System.out.println("      >>><3>"+lideres[7].toString());
		   	        	csvWriter.append(String.join(",", lideres[7].toString()));
	     		       	csvWriter.append("\n");
		   	            System.out.println("      >>><4>"+lideres[6].toString());
		   	            csvWriter.append(String.join(",", lideres[6].toString()));
	     		       	csvWriter.append("\n");
		   	            System.out.println("      >>><5>" + lideres[5].toString());
		   	            csvWriter.append(String.join(",", lideres[5].toString()));
	     		       	csvWriter.append("\n");
		   	            System.out.println("      >>><6>"+lideres[4].toString());
		   	            csvWriter.append(String.join(",", lideres[4].toString()));
	     		       	csvWriter.append("\n");
		   	        	System.out.println("      >>><7>" + lideres[3].toString());
		   	        	csvWriter.append(String.join(",", lideres[3].toString()));
	     		       	csvWriter.append("\n");
		   	        	System.out.println("      >>><8>"+lideres[2].toString());
		   	        	csvWriter.append(String.join(",", lideres[2].toString()));
	     		       	csvWriter.append("\n");
		   	            System.out.println("      >>><9>"+lideres[1].toString());
		   	            csvWriter.append(String.join(",", lideres[1].toString()));
	     		       	csvWriter.append("\n");
		   	            System.out.println("     >>><10>" + lideres[0].toString());
		   	            csvWriter.append(String.join(",", lideres[0].toString()));
	     		       	csvWriter.append("\n");
	            		lideres[0] = nulo;
	          	        lideres[1] = nulo;
	          	        lideres[2] = nulo;
	          	        lideres[3] = nulo;
	          	        lideres[4] = nulo;
	          	        lideres[5] = nulo;
	          	        lideres[6] = nulo;
	          	        lideres[7] = nulo;
	          	        lideres[8] = nulo;
	          	        lideres[9] = nulo;
	            	}
	            	
	            	//}
	            line = br.readLine();
	            i++;
	         }
	         csvWriter.flush();  
			 csvWriter.close();
	         
	      } catch (Exception e) {
	        System.out.println(e.toString());
	      } finally {
	         if (null!=br) {
	            try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	      }}
}
//declaracion de elemento

class Elemento{
	
	protected int date_number;
	private int product_id;
	private int color_id;
	private int size_id;
	protected int sales;
	private int stock;
	private int repeticiones;
	
	public Elemento(int dn, int pid, int cid, int sid, int s, int st) {
		this.date_number = dn;
		this.product_id = pid; 
		this.color_id = cid;
		this.size_id = sid;
		this.sales = s;
		this.stock = st;
	}
	
	public void incrementar() {
		this.repeticiones ++;
	}
	
	//compruebo items para elegir el mejor de todos
	public boolean compareItem(Elemento b) {
		if(this.sales <= b.sales) {
			return true;
		}
		return false;
	}

	public String toString() {
		int i1 = 0,i2 = 0,i3 = 0,i4= 0,i5= 0,i6= 0,i7= 0;
		
		BufferedReader br2;
		try {
			//declaro la lectura del siguiente archivo
			br2 = new BufferedReader(new FileReader("src/stock2.csv"));
	       
			String line2 = br2.readLine();
			line2 = br2.readLine();
			
			while(null != line2) {
				String [] field = line2.trim().split(",");
				if(Integer.parseInt(field[0]) == this.product_id && Integer.parseInt(field[1]) == this.color_id && Integer.parseInt(field[2]) == this.size_id) {
					i1 = Integer.parseInt(field[3]);
					i2 = Integer.parseInt(field[4]);
					i3 = Integer.parseInt(field[5]);
					i4 = Integer.parseInt(field[6]);
					i5 = Integer.parseInt(field[7]);
					i6 = Integer.parseInt(field[8]);
					i7 = Integer.parseInt(field[9]);
					break;
				}
				line2 = br2.readLine();
			}
			
		} catch(Exception e) {}
		return ("       ["+ (this.date_number +1)+"]: ID: " + this.product_id + " | Color ID: " + this.color_id + 
				" | Size ID: " + this.size_id + " | Sales: " + this.sales + " | Stock: " + this.stock + 
				"|stock_replenishment_days71: " + i1 + "|stock_r_days72: " + i2 +
				"|stock_r_days73: " + i3 + "|stock_r_days74: " + i4+
				"|stock_r_days75: " + i5+ "|stock_r_days76: " + i6 +
				"|stock_r_days77: " + i7);
	}
}










