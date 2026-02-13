/*
 * Copyright (c) 2011-2026 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */
package io.vertx.core.net.impl;

import io.netty.buffer.ByteBufUtil;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.TLV;

public class HAProxyTLV implements TLV {

  private final Buffer type;
  private final Buffer value;

  public HAProxyTLV(Buffer type, Buffer value) {
    this.type = type;
    this.value = value;
  }

  public static TLV from(io.netty.handler.codec.haproxy.HAProxyTLV haProxyTLV) {
    Buffer type = Buffer.buffer().appendByte(haProxyTLV.typeByteValue());
    Buffer value = Buffer.buffer(ByteBufUtil.getBytes(haProxyTLV.content()));
    return new HAProxyTLV(type, value);
  }

  @Override
  public Buffer type() {
    return type;
  }

  @Override
  public Buffer value() {
    return value;
  }
}
