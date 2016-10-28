package cr.ac.tec.ce2103.Estructuras.Lista;

import cr.ac.tec.ce2103.Estructuras.Estructura.GenLista;
import cr.ac.tec.ce2103.Estructuras.Estructura.GenNodo;


public class Simple<T> implements GenLista<T> {
	
	
	private GenNodo<T> _head;


	public Simple(){
		this._head = null;
		
	}
	
	/**
	 * Metodo que inserta segun posicion
	 */
	

	public void Insertar(String pDato,T Atrib, int pos) {
		if (pos <= tamaño() + 1)    {
            GenNodo<T> nuevo = new GenNodo<>(pDato,Atrib);
            if (pos == 0){
                nuevo.set_Siguiente(_head);
                _head = nuevo;
            }else if (pos == -1){
            	if(tamaño() == 0){
                    _head = nuevo;
            	}else{
            		GenNodo<T> tmp = _head;
                    while (tmp.get_Siguiente()!= null) {
                        tmp = tmp.get_Siguiente();
                    }
                    tmp.set_Siguiente(nuevo);
            	}
            }else
                if (pos == tamaño() + 1)    {
                    GenNodo<T> tmp = _head;
                    while (tmp.get_Siguiente()!= null) {
                        tmp = tmp.get_Siguiente();
                    }
                    tmp.set_Siguiente(nuevo);
                  
//                    nuevo.set_next(null);
                }else {
                    GenNodo<T> tmp = _head;
                    for (int i = 0 ; i <= pos - 2 ; i++)
                        tmp = tmp.get_Siguiente();
                    GenNodo<T> siguiente = tmp.get_Siguiente();
                    tmp.set_Siguiente(nuevo);
                   
                    nuevo.set_Siguiente(siguiente);
                }
		}
	}
	/**
	 * Metodo que Borra al final
	 */
	@Override
	public T Borrar(int pos) {
		 if (pos <= tamaño())    {
	            if (pos == 0) {
	                _head = _head.get_Siguiente();
	            } else {
	                GenNodo<T> tmp = _head;
	                for (int i = 0 ; i <= pos - 2 ; i++)
	                    tmp = tmp.get_Siguiente();
	                GenNodo<T> siguiente = tmp.get_Siguiente();
	                siguiente = siguiente.get_Siguiente();
	                tmp.set_Siguiente(siguiente);
	            }
	        }
			return null;   
	}
	
	
	/**
	 * Metodo que busca un elemento
	 */
	@Override
	public T Buscar(T pDato) {
        GenNodo<T> tmp = _head;
        while (tmp != null){
        	if(tmp.get_Criatura() == pDato){
        		System.out.println("Encontrado: "+tmp.get_Criatura());
        		return (T) tmp.get_Criatura();
        	}
        	else
        		tmp = tmp.get_Siguiente();
        }
        return null;
	}
	
	/**
	 * Metodo que imprime la lista 
	 */
	@Override
	public void Imprimir() {
		GenNodo<T> tmp = _head;
		String L = "";
		while (tmp != null){
			L += tmp.get_Criatura();
			tmp = tmp.get_Siguiente();
		}
		System.out.println(L);

	}
	@Override
	public T Retornar(int pos) {
		if(tamaño() != 0){
			GenNodo<T> tmp = _head;
			for(int i=0; pos <= tamaño() && i < pos;i++){
				tmp = tmp.get_Siguiente();
			}return tmp.get_Atrib();
		}
		return null;
	}

	@Override
	public int tamaño() {
		int cant = 0;
        GenNodo<T> tmp = _head;
        while (tmp != null) {
            tmp = tmp.get_Siguiente();
            cant++;
        }
        return cant;
	}

	@Override
	public GenNodo<T> RetornarNodo(int pos) {
		if(tamaño() != 0){
			GenNodo<T> tmp = _head;
			for(int i=0; pos <= tamaño() && i < pos;i++){
				tmp = tmp.get_Siguiente();
			}return tmp;
		}
		return null;
	}

}
