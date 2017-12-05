/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Generated code


import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import scala.util.parsing.combinator.testing.Str;

import java.io.*;

public class JavaClient {
  public static void main(String [] args) {

    try {
      TTransport transport;
      transport = new TSocket("localhost", 9090);
      transport.open();
      TProtocol protocol = new  TBinaryProtocol(transport);
      Helloworld.Client client = new Helloworld.Client(protocol);

      perform(client);

      transport.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private static void perform(Helloworld.Client client) throws TException
  {
//    String[] abc={"hello","you are not good","what is your name"};

    BufferedReader reader=null;
    String  filePath="data/data";
    try {
      reader = new BufferedReader(new FileReader(filePath));

      String line =null;
      while ((line=reader.readLine())!=null){
        int index=line.trim().indexOf("http");
        if(index==-1){
          System.out.println("error url");
          continue;
        }
        String url=line.trim().substring(index);
        System.out.println(url);
        String result=client.getVideoActors(url);
        System.out.println("client result = "+result);
      }
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
