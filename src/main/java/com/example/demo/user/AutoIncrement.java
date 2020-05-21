package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AutoIncrement {
    private AtomicLong id;

    public AutoIncrement() {
        id = new AtomicLong();
        this.id.set(1);
    }

    public long getId() {
        return id.get();
    }

    public void autoIncrement() {
        this.id.incrementAndGet();
    }

    @Override
    public String toString() {
        return String.valueOf(this.id.get());
    }
}
