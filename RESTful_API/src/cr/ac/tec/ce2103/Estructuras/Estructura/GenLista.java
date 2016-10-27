package cr.ac.tec.ce2103.Estructuras.Estructura;

public interface GenLista<T> {
	
	public void Insertar(T pDato, int pos);
	public int tamaño();
	public T Retornar(int pos);
	public GenNodo<T> RetornarNodo(int pos);
	public T Borrar(int pos);
	public T Buscar(T pDato);
	public void Imprimir();
	

}
