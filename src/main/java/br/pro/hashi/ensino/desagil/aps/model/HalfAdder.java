package br.pro.hashi.ensino.desagil.aps.model;

public class HalfAdder extends Gate {
    public HalfAdder() {
        super("HalfAdder", 2, 2);
    }

    @Override
    public boolean read(int outputPin) {
        return false;
    }

    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
    }
}
