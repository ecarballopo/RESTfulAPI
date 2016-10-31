package cr.ac.tec.ce2103.Estructuras.Estructura;

public interface GenLista<T> {
	
	public void Insertar(String pDato,T Atrib, int pos);
	public void Insertar(T pDato, int pos);
	public int tamaño();
	public T Retornar(int pos);
	public GenNodo<T> RetornarNodo(int pos);
	public int RetornarPos(int dato);
	public T Borrar(int pos);
	public T Buscar(T pDato);
	public void Eliminar();
	public void Imprimir();
	

}
