package cr.ac.tec.ce2103.Estructuras.Estructura;

public class GenNodo<T> {

	private T _Dato;
	private boolean _Free;
	private GenNodo<T> _Siguiente;
	private GenNodo<T> _Anterior;
	
	public GenNodo(T pDato){
		this._Dato = pDato;
		this._Free = false;
		this._Siguiente = null;
		this._Anterior = null;
	}

	public boolean is_Free() {
		return _Free;
	}

	public void set_Free(boolean _Free) {
		this._Free = _Free;
	}

	public T get_Dato() {
		return _Dato;
	}

	public void set_Dato(T _Dato) {
		this._Dato = _Dato;
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
