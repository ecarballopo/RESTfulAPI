package cr.ac.tec.ce2103.Estructuras.Lista;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Estructura.GenNodo;

public class DobleEnlazada<T> implements GenLista<T> {

	private GenNodo<T> _raiz;

	public DobleEnlazada(){
		this._raiz = null;
	}
	/**
	 * Devuelve el tamaño de la lista
	 * @return
	 */
	 public int tamaño(){
	        int cant = 0;
	        GenNodo<T> tmp = _raiz;
	        while (tmp != null) {
	            tmp = tmp.get_Siguiente();
	            cant++;
	        }
	        return cant;
	    }
	 /**
	  * Metodo que retorna el primer nodo de la lista
	  */
	@Override
	public T Retornar(int pos) {
		if(tamaño() != 0){
			GenNodo<T> tmp = _raiz;
			for(int i=1; pos <= tamaño() && i < pos;i++){
				tmp = tmp.get_Siguiente();
			}return tmp.get_Atrib();
		}
		return null;
	}
	 
	/**
	 * Metodo que inserta segun posicion dada
	 */
	@Override
	public void Insertar(String pDato,T Atrib,int pos) {
		if (pos <= tamaño())    {
            GenNodo<T> nuevo = new GenNodo<T>(pDato,Atrib);
            if (pos == 0){
                nuevo.set_Siguiente(_raiz);
                if (_raiz != null)
                    _raiz.set_Anterior(nuevo);
                _raiz = nuevo;
            } else
                if (pos == tamaño())    {
                    GenNodo<T> tmp = _raiz;
                    while (tmp.get_Siguiente()!= null) {
                        tmp = tmp.get_Siguiente();
                    }
                    tmp.set_Siguiente(nuevo);
                    nuevo.set_Anterior(tmp);
                    nuevo.set_Siguiente(null);
                } else {
                    GenNodo<T> tmp = _raiz;
                    for (int i = 0 ; i <= pos - 1 ; i++)
                        tmp = tmp.get_Siguiente();
                    GenNodo<T> siguiente = tmp.get_Siguiente();
                    tmp.set_Siguiente(nuevo);
                    nuevo.set_Anterior(tmp);
                    nuevo.set_Siguiente(siguiente);
                    siguiente.set_Anterior(nuevo);
                }
        }

	}
	/**
	 * Borra segun la posicion dada
	 */
	@Override
	public T Borrar(int pos) {
	    if (pos <= tamaño())    {
            if (pos == 0) {
                _raiz = _raiz.get_Siguiente();
                if (_raiz != null)
                    _raiz.set_Anterior(null);
            } else {
                GenNodo<T> tmp = _raiz;
                for (int i = 0 ; i <= pos - 2 ; i++)
                    tmp = tmp.get_Siguiente();
                GenNodo<T> siguiente = tmp.get_Siguiente();
                siguiente = siguiente.get_Siguiente();
                tmp.set_Siguiente(siguiente);
                if (siguiente != null)
                    siguiente.set_Anterior(tmp);
            }
        }
		return null;
	}
	/**
	 * Busca segun la posicion dada
	 */
	@Override
	public T Buscar(T pDato) {
		  GenNodo<T> tmp = _raiz;
	        while (tmp != null) {
	            if (tmp.get_Criatura() == pDato){
	            	System.out.println("Encontrado: "+tmp.get_Criatura());
	                return (T) tmp.get_Criatura();
	            }
	            tmp = tmp.get_Siguiente();
	        }
	        return null;
	}

	@Override
	public void Imprimir() {
		GenNodo<T> tmp = _raiz;
		String L = "";
		while (tmp != null){
			L += tmp.get_Criatura();
			tmp = tmp.get_Siguiente();
		}
		System.out.println(L);

	}
	@Override
	public GenNodo<T> RetornarNodo(int pos) {
		if(tamaño() != 0){
			GenNodo<T> tmp = _raiz;
			for(int i=0; pos <= tamaño() && i < pos;i++){
				tmp = tmp.get_Siguiente();
			}return tmp;
		}
		return null;
	}

}
