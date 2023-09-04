package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEquals {

    public static void main(String[] args) {

        Map<Team, String> map = new HashMap<>();

        map.put(new Team("Bangalore", "marketing"), "Sudha");
        map.put(new Team("Mumbai", "finance"), "Shailesh");

        Team newTeam = new Team("Mumbai", "finance");
        System.out.println( map.get(newTeam));

    }

}

class Employee {
    private int id;
    private String name;
    private Address address;

    public boolean equals(Object o){
        if(o == this)
            return true;

        if(o == null)
            return false;

        if (this.getClass() != o.getClass()) return false;

        Employee hce = (Employee) o;
        boolean sampleClassEquals = (this.address == null && hce.address == null ) || (hce.address != null && this.address.equals(hce.address));
        boolean nameEquals = (this.name==null && hce.name == null) || (hce.name!=null && this.name.equals(hce.name));
        return this.id == hce.id && sampleClassEquals && nameEquals;
    }

    /*
        equals() contract
        1. reflexive: equals to self should be true
        2. symmetric: x.equals(y) should also means y.equals(x)
        3. transitive: if x.equals(y) and y.equals(z) then x.equals(z) should be true
        4. consistent: outcome of equals() should not change until property considered for equals() change. i.e. no randomness allows

        If we override the equals() method, we also have to override hashCode().

        hashCode() contract
        1. internal consistency: the values of hashCode() may change only when properties considered for equals() changes.
        2. equals consistency: objects that are equal to each other, should have same hash code
        3. collisions: unequal objects may have same hash code

        hashCode() and equals() need to be overridden only for classes that we want to use as map keys, not for classes that are only used as values in a map.

     */
}

class Address{

}

class Team{
    String city;
    String dept;
    public Team(final String city, final String dept) {
        this.city = city;
        this.dept = dept;
    }

    public boolean equals(Object o) {
        if(o == this)
            return true;

        if(o == null)
            return false;

        if (this.getClass() != o.getClass()) return false;

        Team t = (Team) o;

        //         return Objects.equals(this.city, t.city) && Objects.equals(this.dept, t.dept);

        boolean cityEquals = (this.city == null && t.city == null) || (t.city!=null && this.city.equals(t.city));
        boolean deptEquals = (this.dept == null || t.dept == null) || (t.dept!=null && this.dept.equals(t.dept));

        return cityEquals && deptEquals;
    }

    /*
        If we don't implement hashCode() then, when Team class is used as key of HashMap, we will get inconsistent equality.

        see line # 10-16
     */

    public int hashCode(){
        int result = 17;
        if(city != null){
            result = 31 * result + (city==null?0:city.hashCode());
        }
        if(dept != null){
            result = 31 * result * (dept==null?0:dept.hashCode());
        }
        return result;
    }
}


