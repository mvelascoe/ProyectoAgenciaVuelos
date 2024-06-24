package com.proyectojava.utility;

import java.util.Optional;

public interface Validator <T>{
    Optional<T> validate(String input);
}

