package cr.ac.tec.ce2103.Estructuras.Estructura;

public class GenNodo<T> {

	private String _Criatura;
	private T _Dato;
	private T _Atrib;
	private GenNodo<T> _Siguiente;
	private GenNodo<T> _Anterior;
	
	public GenNodo(String pDato,T Atrib){
		this._Criatura = pDato;
		this._Atrib = Atrib;
		this._Siguiente = null;
		this._Anterior = null;
	}
	
	public GenNodo(T pDato){
		this._Dato = pDato;
		this._Siguiente = null;
		this._Anterior = null;
	}
	
	public T get_Dato() {
		return _Dato;
	}

	public void set_Dato(T _Dato) {
		this._Dato = _Dato;
	}

	public String get_Criatura() {
		return _Criatura;
	}

	public void set_Criatura(String _Criatura) {
		this._Criatura = _Criatura;
	}

	public T get_Atrib() {
		return _Atrib;
	}

	public void set_Atrib(T _Atrib) {
		this._Atrib = _Atrib;
	}

	public GenNodo<T> get_Siguiente() {
		return _Siguiente;
	}

	public void set_Siguiente(GenNodo<T> _Siguiente) {
		this._Siguiente = _Siguiente;
	}

	public GenNodo<T> get_Anterior() {
		return _Anterior;
	}

	public void set_Anterior(GenNodo<T> _Anterior) {
		this._Anterior = _Anterior;
	}
}
