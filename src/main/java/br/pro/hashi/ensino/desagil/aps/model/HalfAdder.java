package br.pro.hashi.ensino.desagil.aps.model;

public class HalfAdder extends Gate {
    private final
    AndGate andGate;
    private final
    XorGate xorGate;

    public HalfAdder() {
        super("HalfAdder", 2, 2);
        andGate = new AndGate();
        xorGate = new XorGate();

    }

    @Override
    public boolean read(int outputPin) {
        switch (outputPin) {
            case 0:
                return andGate.read();

            case 1:
                return xorGate.read();

            default:
                throw new IndexOutOfBoundsException(outputPin);
        }
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                xorGate.connect(0, emitter);
                andGate.connect(0, emitter);

                break;
            case 1:
                xorGate.connect(1, emitter);
                andGate.connect(1, emitter);

                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);

        }
    }
}
