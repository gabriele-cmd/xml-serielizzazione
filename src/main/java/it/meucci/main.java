package it.meucci;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class main 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
        File file = new File("src/main/java/it/meucci/classe.xml"); //indico il percorso del file da deserializzare
        XmlMapper xmlMapper = new XmlMapper();
        root value = xmlMapper.readValue(file, root.class);
        System.out.println("La Classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'Aula " + value.getAula().getNome() + " ed è composta dai seguenti Studenti:"); //stampo a schermo il conentuo del file XML
        
        //eseguo un ciclo FOR per stampare tutti gli STUDENTI contenuti nel Vettore
        for(int i = 0; i < value.getStudenti().size(); i++){
            System.out.println("- " + value.getStudenti().get(i).getCognome() + " " + value.getStudenti().get(i).getNome());
        }

        //SERIALIZZAZIONE
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); //Stampo le stringhe una sotto l'altra
        xmlMapper.writeValue(new File("src/main/java/it/meucci/classeAgg.xml"), value); //Serializzo
        File newFile = new File("classeAgg.xml"); //creo nuovo file XML
        
    }
}
