// Main class to demonstrate the parallel hierarchies
public class parallel_inheritance {
    
/*
 * Herencias Paralelas
 *
 * Síntomas:
 * Cada vez que creas una subclase para una clase en una jerarquía, 
 * necesitas crear una subclase correspondiente en una jerarquía paralela. 
 * Por ejemplo, si tienes clases como `ProfesorDeMatemáticas` y 
 * `AlumnoDeMatemáticas`, también debes tener `ProfesorDeFísica` y 
 * `AlumnoDeFísica`, y así sucesivamente.
 *
 * Razones del Problema:
 * Inicialmente, el sistema puede parecer manejable. Sin embargo, a medida 
 * que añades nuevas clases, el mantenimiento se vuelve complicado debido a 
 * la duplicación de código y la necesidad de mantener sincronizadas ambas 
 * jerarquías. Esto hace que realizar cambios o agregar nuevas funcionalidades 
 * sea más difícil y propenso a errores.
 */

// Base classes
abstract class Professor {
    abstract void teach();
}

abstract class Student {
    abstract void study();
}

// Professor subclasses
class MathProfessor extends Professor {
    @Override
    void teach() {
        System.out.println("Teaching math.");
    }
}

class PhysicsProfessor extends Professor {
    @Override
    void teach() {
        System.out.println("Teaching physics.");
    }
}

class SoftwareEngineeringProfessor extends Professor {
    @Override
    void teach() {
        System.out.println("Teaching software engineering.");
    }
}

// Student subclasses
class MathStudent extends Student {
    @Override
    void study() {
        System.out.println("Studying math.");
    }
}

class PhysicsStudent extends Student {
    @Override
    void study() {
        System.out.println("Studying physics.");
    }
}

class SoftwareEngineeringStudent extends Student {
    @Override
    void study() {
        System.out.println("Studying software engineering.");
    }
}


    public static void main(String[] args) {
        Professor mathProfessor = new MathProfessor();
        Professor physicsProfessor = new PhysicsProfessor();
        Professor softwareEngineeringProfessor = new SoftwareEngineeringProfessor();
        
        Student mathStudent = new MathStudent();
        Student physicsStudent = new PhysicsStudent();
        Student softwareEngineeringStudent = new SoftwareEngineeringStudent();
        
        mathProfessor.teach();
        physicsProfessor.teach();
        softwareEngineeringProfessor.teach();
        
        mathStudent.study();
        physicsStudent.study();
        softwareEngineeringStudent.study();
    }
}
