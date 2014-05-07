/**
*    Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior
*    University
* 
*    Licensed under the Apache License, Version 2.0 (the "License"); you may
*    not use this file except in compliance with the License. You may obtain
*    a copy of the License at
*
*         http://www.apache.org/licenses/LICENSE-2.0
*
*    Unless required by applicable law or agreed to in writing, software
*    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
*    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
*    License for the specific language governing permissions and limitations
*    under the License.
**/

package org.openflow.protocol;

import java.util.List;

import junit.framework.TestCase;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.openflow.protocol.factory.BasicFactory;
import org.openflow.protocol.factory.OFMessageFactory;
import org.openflow.protocol.multipart.OFMultipartDataType;
import org.openflow.util.OFTestCase;

public class OFMultipartReplyTest extends OFTestCase {
    public void testOFFlowStatisticsReply() throws Exception {
        byte[] packet = new byte[] { 0x01, 0x11, 0x01, 0x2c, 0x00, 0x00, 0x00,
                0x01, 0x00, 0x01, 0x00, 0x00, 0x00, 0x60, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, (byte) 0xff,
                (byte) 0xff, 0x00, 0x00, 0x08, 0x00, 0x00, 0x01, 0x00, 0x00,
                0x0a, 0x00, 0x00, 0x03, 0x0a, 0x00, 0x00, 0x02, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3a, (byte) 0xa6,
                (byte) 0xa6, 0x00, (byte) 0xff, (byte) 0xff, 0x00, 0x05, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                (byte) 0xc4, 0x00, 0x00, 0x00, 0x08, 0x00, 0x01, 0x00, 0x00,
                0x00, 0x60, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x02, (byte) 0xff, (byte) 0xff, 0x00, 0x00, 0x08, 0x06,
                0x00, 0x02, 0x00, 0x00, 0x0a, 0x00, 0x00, 0x03, 0x0a, 0x00,
                0x00, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x3b, 0x2f, (byte) 0xfa, 0x40, (byte) 0xff, (byte) 0xff, 0x00,
                0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x3c, 0x00, 0x00, 0x00, 0x08, 0x00, 0x01, 0x00,
                0x00, 0x00, 0x60, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x03, (byte) 0xff, (byte) 0xff, 0x00, 0x62, 0x08,
                0x00, 0x00, 0x01, 0x62, 0x37, 0x0a, 0x00, 0x00, 0x02, 0x0a,
                0x00, 0x00, 0x03, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x3a, (byte) 0xc5, 0x2a, (byte) 0x80, (byte) 0xff,
                (byte) 0xff, 0x00, 0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xc4, 0x00, 0x00, 0x00,
                0x08, 0x00, 0x02, 0x00, 0x00 };

        OFMessageFactory factory = BasicFactory.getInstance();
        ChannelBuffer packetBuf = ChannelBuffers.wrappedBuffer(packet);
        List<OFMessage> msg = factory.parseMessage(packetBuf);
        TestCase.assertNotNull(msg);
        TestCase.assertEquals(msg.size(), 1);
        TestCase.assertTrue(msg.get(0) instanceof OFMultipartReply);
        OFMultipartReply sr = (OFMultipartReply) msg.get(0);
        TestCase.assertEquals(OFMultipartDataType.FLOW, sr.getStatisticType());
        TestCase.assertEquals(3, sr.getStatistics().size());
    }
}
