
package br.edu.ifms.crudsoap.servico.jaxws;

import java.util.List;
import br.edu.ifms.crudsoap.modelo.Noticia;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarResponse", namespace = "http://servico.crudsoap.ifms.edu.br/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarResponse", namespace = "http://servico.crudsoap.ifms.edu.br/")
public class ListarResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Noticia> _return;

    /**
     * 
     * @return
     *     returns List<Noticia>
     */
    public List<Noticia> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Noticia> _return) {
        this._return = _return;
    }

}
