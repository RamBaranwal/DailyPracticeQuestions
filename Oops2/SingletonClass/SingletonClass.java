
package Oops2.SingletonClass;

public class SingletonClass {

    // Private constructor prevents object creation from outside the class.
    // Because of this, code like:
    //
    // SingletonClass obj = new SingletonClass();
    //
    // will give a compile-time error.
    //
    // This is the first requirement of the Singleton Pattern:
    // No other class should be able to create objects directly.

    private SingletonClass() {

    }

    // Static because there should be only ONE copy of this variable
    // shared by the entire class.
    //
    // If it were non-static, every object would have its own 'instance'
    // variable, which would defeat the purpose of Singleton.

    private static SingletonClass instance;

    // Static because we need to call this method without creating an object.
    //
    // If this method were not static, we would need an object first:
    //
    // SingletonClass obj = new SingletonClass();
    // obj.getInstance();
    //
    // But creating an object is impossible because the constructor is private.
    //
    // Therefore getInstance() must be static.

    public static SingletonClass getInstance() {

        // Create object only once.
        if (instance == null) {
            instance = new SingletonClass();
        }

        // Return the same object every time.
        return instance;
    }
}

