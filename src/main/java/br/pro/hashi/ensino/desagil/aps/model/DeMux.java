package br.pro.hashi.ensino.desagil.aps.model;

public class DeMux extends Gate {
    public DeMux() {
        super("DeMux", 2, 2);
    }

    @Override
    public boolean read(int outputPin) {
        return false;
    }

    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
    }
}
