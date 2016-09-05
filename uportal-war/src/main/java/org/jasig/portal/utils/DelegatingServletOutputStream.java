/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portal.utils;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * {@link ServletOutputStream} impl that delegates to an {@link OutputStream}
 * 
 * @author Eric Dalquist
 */
public class DelegatingServletOutputStream extends ServletOutputStream {
    private final OutputStream outputStream;
    private final ServletOutputStream servletOutputStream;

    public DelegatingServletOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.servletOutputStream = null;
    }

    public DelegatingServletOutputStream(ServletOutputStream servletOutputStream) {
        this.servletOutputStream = servletOutputStream;
        this.outputStream = servletOutputStream;
    }

    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    public void flush() throws IOException {
        outputStream.flush();
    }

    public void close() throws IOException {
        outputStream.close();
    }

    @Override
    public boolean isReady() {
        if (servletOutputStream != null) {
            return servletOutputStream.isReady();
        }
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        if (servletOutputStream != null) {
            servletOutputStream.setWriteListener(writeListener);
        }
    }
}
