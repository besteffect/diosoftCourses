/**
 * Created by user on 9/23/15.
 */
public class Person {
    private final String firstName;
    private final String secondName;
    private final String age;
    private Person(Builder builder){
        this.firstName=builder.firstName;
        this.secondName=builder.secondName;
        this.age=builder.age;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (secondName != null ? !secondName.equals(person.secondName) : person.secondName != null) return false;
        return !(age != null ? !age.equals(person.age) : person.age != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", age='").append(age).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{
        private String firstName;
        private  String secondName;
        private String age;

        public Builder(){
        }

        public Builder (Person original){
            this.firstName=original.firstName;
            this.secondName=original.secondName;
            this.age=original.age;
        }

        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder secondName(String secondName){
         this.secondName=secondName;
            return this;
        }

        public Builder age(String age){
            this.age=age;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}
