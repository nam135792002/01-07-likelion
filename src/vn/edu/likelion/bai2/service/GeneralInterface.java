package vn.edu.likelion.bai2.service;

import vn.edu.likelion.bai2.exception.NotFoundException;

public interface GeneralInterface<T> {
    void create() throws NotFoundException;
    void printALl() throws NotFoundException;
    default T findById(int id){return null;}
    default T findById(int id1, int id2) throws NotFoundException{return null;}
}
