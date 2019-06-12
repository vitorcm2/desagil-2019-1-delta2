package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeMuxTest {
    private DeMux gate;

    private void build(boolean a, boolean b) {
        gate = new DeMux();
        gate.connect(0, new MockEmitter(a));
        gate.connect(1, new MockEmitter(b));
    }

    @Test
    public void whenReceivingFalseAndFalseShouldReturnFalseAndFalse() {
        build(false, false);
        Assertions.assertFalse(gate.read(0));
        Assertions.assertFalse(gate.read(1));
    }

    @Test
    public void whenReceivingFalseAndTrueShouldReturnFalseAndFalse() {
        build(false, true);
        Assertions.assertFalse(gate.read(0));
        Assertions.assertFalse(gate.read(1));
    }

    @Test
    public void whenReceivingTrueAndFalseShouldReturnTrueAndFalse() {
        build(true, false);
        Assertions.assertTrue(gate.read(0));
        Assertions.assertFalse(gate.read(1));
    }

    @Test
    public void whenReceivingTrueAndTrueShouldReturnFalseAndTrue() {
        build(true, true);
        Assertions.assertFalse(gate.read(0));
        Assertions.assertTrue(gate.read(1));
    }
}
