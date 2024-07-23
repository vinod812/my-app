package resttest;
public class pojoclass {
 private String name;
 private int age;
	public pojoclass() {
	// TODO Auto-generated constructor stub
    }
	public pojoclass(String name, int age) {
		this.name=name;
		this.age=age;		
	}	
	//Getter
	public void setname(String name){
	this.name=name;	
	}
	public String getname() {
		return this.name;
	}
	//Setter
	public void setage(int age) {
		this.age=age;
	}
	public int getage(){
		return this.age;
	}
	
}
