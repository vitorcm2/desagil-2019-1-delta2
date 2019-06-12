package br.pro.hashi.ensino.desagil.aps.model;

public class DeMux extends Gate {
    NandGate nandTop1;
    NandGate nandBottom1;
    NandGate nandTop2;
    NandGate nandBottom2;


    public DeMux() {
        super("DeMux", 2, 2);
        nandTop1 = new NandGate();
        nandBottom1 = new NandGate();
        nandTop2 = new NandGate();
        nandBottom2 = new NandGate();


        nandBottom2.connect(0, nandBottom1);
        nandBottom2.connect(1, nandBottom1);

        nandTop2.connect(0, nandTop1);
        nandTop2.connect(1, nandTop1);

    }


    @Override
    public boolean read(int outputPin) {
        if (outputPin == 0) {
            return nandTop2.read();
        } else if (outputPin == 1) {
            return nandBottom2.read();
        } else
            throw new IndexOutOfBoundsException(outputPin);
    }

    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                nandTop1.connect(1, emitter);
                nandBottom1.connect(0, emitter);
                break;
            case 1:
                nandTop1.connect(0, emitter);
                nandBottom1.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
    }
}
