/*******************************************************************************
 * QMetry Automation Framework provides a powerful and versatile platform to author 
 * Automated Test Cases in Behavior Driven, Keyword Driven or Code Driven approach
 *                
 * Copyright 2016 Infostretch Corporation
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT
 * OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE
 *
 * You should have received a copy of the GNU General Public License along with this program in the name of LICENSE.txt in the root folder of the distribution. If not, see https://opensource.org/licenses/gpl-3.0.html
 *
 * See the NOTICE.TXT file in root folder of this source files distribution 
 * for additional information regarding copyright ownership and licenses
 * of other open source software / files used by QMetry Automation Framework.
 *
 * For any inquiry or need additional information, please contact support-qaf@infostretch.com
 *******************************************************************************/
package com.qmetry.qaf.automation.impl;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;
import org.testng.collections.Maps;

/**
 * @author chirag.jayswal
 *
 */
public class CustomDataProvider {
	@DataProvider(name="dp-without-injection")
	public static Object[][] dataProviderForBDD(){
		Map<Object, Object> m = Maps.newHashMap();
		m.put("value", "OK");
		return new Object[][]{{m}};
	}
	
	@DataProvider(name="dp-with-testngmethod")
	public Object[][] dataProviderForBDD(ITestNGMethod method){
		Map<Object, Object> m = Maps.newHashMap();
		m.put("method", method.getMethodName());
		return new Object[][]{{m}};
	}
	
	@DataProvider(name="dp-with-method")
	public Object[][] dataProviderForBDD(Method method){
		Map<Object, Object> m = Maps.newHashMap();
		m.put("method", method.getName());
		return new Object[][]{{m}};
	}
	
	@DataProvider(name="dp-with-testngmethod-contex")
	public Object[][] dataProviderForBDD(ITestNGMethod method, ITestContext contex){
		Map<Object, Object> m = Maps.newHashMap();
		m.put("method", method.getMethodName());
		m.put("contex", contex.getName());
		return new Object[][]{{m}};
	}
	
	@DataProvider(name="dp-for-filter")
	public static Object[][] dataProviderToTestFilter(){
		Map<Object, Object> m = Maps.newHashMap();
		m.put("name", "a");
		m.put("uname", "a");

		m.put("id", 1);
		
		Map<Object, Object> m2 = Maps.newHashMap();
		m2.put("name", "b");
		m2.put("uname", "b");

		m2.put("id", 2);

		Map<Object, Object> m3 = Maps.newHashMap();
		m3.put("name", "c");
		m3.put("uname", "c");

		m3.put("id", 3);
		
		Map<Object, Object> m4 = Maps.newHashMap();
		m4.put("name", "d");
		m4.put("uname", "d");

		m4.put("id", 4);

		Map<Object, Object> m5 = Maps.newHashMap();
		m5.put("name", "e");
		m5.put("uname", "e");

		m5.put("id", 5);
		return new Object[][]{{m},{m2},{m3},{m4},{m5}};
	}
}
