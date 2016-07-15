package com.company.bst;

/**
 * Created by Igor on 4/5/16.
 */

public class NullableNode extends Node {

    public static final NullableNode INSTANCE = new NullableNode();

    private  NullableNode() {

        super(null, null, null, null);
    }

    @Override
    public final int getHeight() {

        return 0;
    }
}
