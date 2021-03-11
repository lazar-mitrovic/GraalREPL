package com.oracle.labs.repl.util.languages;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Context.Builder;
import org.graalvm.polyglot.Value;

import java.util.function.IntSupplier;

public class RAdapter implements LanguageAdapter {
    public Builder addParameters(Builder builder) {
        return builder;
    }

    public void putBindings(Context context, IntSupplier clear, IntSupplier exit) {
        Value bindings = context.getBindings("R");
        bindings.putMember("clear", clear);
        bindings.putMember("quit", exit);
        bindings.putMember("exit", exit);
    }

    public String initCode() {
        return "cat(R.version.string)\ncat('\n')";
    }
}