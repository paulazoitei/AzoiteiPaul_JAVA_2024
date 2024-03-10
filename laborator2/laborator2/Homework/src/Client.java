import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;
    private boolean assigned;

    /**
     *  constructorul implicit pentru clasa Client
     */
    public Client() { }

    /**
     * acest constructor creează o nouă instanță a clasei Client și îi setează numele si tipul folosind valoarile furnizate ca argument name,type
     * @param name reprezinta numele clientului
     * @param type reprezinta tipul clientului ,regular sau premium
     */
    public Client(String name,ClientType type)
    {
        this.name=name;
        this.type=type;
    }

    /**
     * constructor pentru a initializa minTime si maxTime cu null pentru un anumit client
     * @param name reprezinta numele clientului
     */
    public Client(String name) {
        this(name, null, null);
    }

    /**
     * constructor pentru a initializa membrii privati nume ,minTime si maxTime cu valori exterioare din parametru
     * @param name reprezinta numele clientului
     * @param minTime partea din stanga a intervalului care reprezinta cat sta clientul cu masina
     * @param maxTime partea din dreapta a intervalului care reprezinta cat sta clientul cu masina
     */
    public Client(String name, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime=minTime;
        this.maxTime=maxTime;

    }

    /**
     * metoda pentru a obtine numele
     * @return numele clientului de tipul String
     */
    public String getName() {
        return name;
    }

    /**
     * metoda pentru a obtine ora de la care poate merge clientul cu o masina
     * @return ora de la care poate merge clientul cu masina de tip LocalTime
     */

    public LocalTime getMinTime() {
        return minTime;
    }

    /**
     * metoda pentru a seta ora de la care poate merge clientul cu o masina
     * @param minTime ora de la care poate merge clientul cu masina
     */

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }
    /**
     * metoda pentru a obtine ora pana la  care poate merge clientul cu o masina
     * @return ora pana la care poate merge clientul cu masina de tip LocalTime
     */
    public LocalTime getMaxTime() {
        return maxTime;
    }
    /**
     * metoda pentru a seta ora pana la care poate merge clientul cu o masina
     * @param maxTime ora pana la  care poate merge clientul cu masina
     */

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    /**
     * metoda pentru a returna tipul clientului
     * @return tipul clientului de tip ClientType
     */
    public ClientType getType() {
        return type;
    }

    /**
     * metoda pentru a seta tipul clientului
     * @param type tipul clientului poate fi REGULAR sau PREMIUM
     */
    public void setType(ClientType type) {
        this.type = type;
    }

    /**
     *acest membru reprezinta o colectie neordonata de elemente unice de tip String
     * se creeaza o noua instanta a clasei HashSet
     */
    private static Set<String> uniqueClientsNames = new HashSet<>();

    /**
     *metoda pentru a seta numele clientului astfel incat fiecare sa aiba un nume unic,daca un nume deja folosit se incearca a fi setat va fi
     * aruncata o exceptie ,daca o metoda incearca sa-si modifice numele intr un nume deja folosit acesta va fi sters
     * @param name reprezinta numele clientului
     */

    public void setName(String name) {
        if (!uniqueClientsNames.contains(name)) {
            uniqueClientsNames.remove(this.name);
            this.name = name;
            uniqueClientsNames.add(name);
        } else {
            throw new IllegalArgumentException("Client name must be unique.");
        }
    }

    /**
     * metoda pentru afisa clientii si datele aferente lor ,nume ,ora de la care pot calatori cu masina,ora pana la care pot calatori cu masina,
     * tipul clientului
     * @return un String cu toate datele despre un client
     */

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", type=" + type +
                '}';
    }

    /**
     * metoda pentru a verifica  daca 2 obiecte sunt egale pentru a nu exista duplicate
     * @param o un obiect care va fi comparat
     * @return daca 2 obiecte sunt egale se va retunra true daca nu ,false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    /**
     * metoda pentru a verifica daca un client este asignat unui vehicul
     * @return true daca este asignat false daca nu
     */
    public boolean isAssigned() {
        return assigned;
    }

    /**
     * metoda pentru a seta adevarat daca clientul este asignat sau fals daca nu
     * @param assigned poate fi true sau false
     */

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}
