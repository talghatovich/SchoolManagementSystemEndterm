package com.company.repositories.interfaces;

import com.company.entities.Parent;
import com.company.entities.Student;

public interface IParentRepository {
    Student getChild(Parent parent);
}
