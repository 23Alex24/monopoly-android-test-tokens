```
07-13 17:55:53.552 28679 28880 I okhttp.OkHttpClient: --> POST https://abc.monopoly.su/some-api/v1/auth/login
07-13 17:55:53.554 28679 28880 I okhttp.OkHttpClient: {"code":"1111","phone":"79626156190"}
07-13 17:55:53.554 28679 28880 I okhttp.OkHttpClient: --> END POST (37-byte body)
 
07-13 17:55:53.723 28679 28880 I okhttp.OkHttpClient: <-- 200 OK https://abc.monopoly.su/some-api/v1/auth/login (167ms)
07-13 17:55:53.734 28679 28880 I okhttp.OkHttpClient: {"userId":"dde85c6d-d1d2-47ba-ba7c-123124324","accessToken":{"token":"eyJhbGciOiJBMjU2S1ciLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwidHlwIjoiSldUIn0.wFKgm2giYhvhHfWt2J_QNUu03fZincnCakk713hWGZzqiiA0mLK_NUFeT5JpZb0CYA5aoKoR83E3wf7FaewKb6tDK6PKsDmq.a17nh-pz2wbmIoRtihyXqw.0QhXtxmCaMeZm98C6XLV-uLMyr81D2uDuReC_P454HoGIeDQ1PmA5Jk7Ir0MsLljTQLXlAW_Bmzk9zwAno4NObLZLhAmmWuXWJlMswFG-1LOMLBHGmsaVy6NptHdQSNSAGKYj1zSDbltF2lBfiAYouj6ThcFOH9VdTfDjAmcacQmh3NhLRtcx6mrGcuGfRbmn2HfwnRqP1hZzlZQU9fsArFAkYZkpDOONYgfqrChOnSCx1at70Agu16JwUFBmxDDlJEqwZX73iutdZt2xqGw4d_tqOCyc90S5y4Abdf4t67RNJsotJ2RWnOKsbSDuJKnHuj6y5s8LBZR8SBU2WjvNoMmQ3KD8LAXRLmXM0jPW6F0IBy35tG75I0BJITbqxEWlCeGEkLEVK_UmX64FdrwdFS81vtdyeG-ZULLJr8eQi4Mn__RXHosCD7ueAbnUEafTqyLMPk8Um7oQO-8ScUTuazD4ERJEtcGO2b237784w482cutqRXjgra3_sr45gjfeUcZ6mv526TD1FFw9vm82qinblnNmxfCp6_MJIKuIgcyXdv2VB-0Foei9UYOEmSsfscljEu1qyOcUllRt7QPPlk6YxbgJyJMC9ziAFYFa9G1qNRf-h4JAiB9TgJEf4GWVSpHLtDbM4bCT8PaZap_P8Nw8XWRW3Z4q3SRmiaQGypHhSo9ti1XBQrX74umOVjO-S87vqY5UVxM9bE5FBcoPW62w8BMng9qsc10uJKSqbIOmzaiLyX9XvMuESs__-ohAng4uvjyXabCHZEImgneseHDchUnjwOOKbdNoPs4jt91oOGBb-PDGP-zgLhBPcyLEfXoEUH6u8WpF4f20k5ajpuEUD3KwIOdvBVT8-dbZ6D1acCpQXChOBmyd311o5uxvm9jkATfBzPZoX3jcYLBHw.bKPrmywT1AlvLGPRdKndJxITjZe-F8VRCrFybW5ZFbk","validTo":"2022-07-13T14:57:24+00:00"},"refreshToken":{"token":"JyP+J00ULCmCCoh/TqnbKtaxY0vQEKI4VlSgLfgAwOHmsVXtKhoXqlJNY81ByyHOqoFs51tUUEw9Uw9g44F5nSZe3/Um/3s8hC8TqTgpN8XrmwCIyDZqTG+3caSA4Pb82WksBGwwZJwTRTvGQ5AoIwH4lo+OvAy9HLyRdQ4jcqfS22I7NnbsLHJM5jfYzSa/Wd/HEUMg55bNRqZPxQDnFAmOPP0bh7y5vcvHWfAL/ck=","validTo":"2022-07-25T15:10:54.5026581+03:00"}}
07-13 17:55:53.734 28679 28880 I okhttp.OkHttpClient: <-- END HTTP (1574-byte body)
.....
.....
.....
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: --> GET https://abc.monopoly.su/some-api/v1/items?Offset=0&Limit=30&Status=Active
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: Authorization: Bearer eyJhbGciOiJBMjU2S1ciLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwidHlwIjoiSldUIn0.wFKgm2giYhvhHfWt2J_QNUu03fZincnCakk713hWGZzqiiA0mLK_NUFeT5JpZb0CYA5aoKoR83E3wf7FaewKb6tDK6PKsDmq.a17nh-pz2wbmIoRtihyXqw.0QhXtxmCaMeZm98C6XLV-uLMyr81D2uDuReC_P454HoGIeDQ1PmA5Jk7Ir0MsLljTQLXlAW_Bmzk9zwAno4NObLZLhAmmWuXWJlMswFG-1LOMLBHGmsaVy6NptHdQSNSAGKYj1zSDbltF2lBfiAYouj6ThcFOH9VdTfDjAmcacQmh3NhLRtcx6mrGcuGfRbmn2HfwnRqP1hZzlZQU9fsArFAkYZkpDOONYgfqrChOnSCx1at70Agu16JwUFBmxDDlJEqwZX73iutdZt2xqGw4d_tqOCyc90S5y4Abdf4t67RNJsotJ2RWnOKsbSDuJKnHuj6y5s8LBZR8SBU2WjvNoMmQ3KD8LAXRLmXM0jPW6F0IBy35tG75I0BJITbqxEWlCeGEkLEVK_UmX64FdrwdFS81vtdyeG-ZULLJr8eQi4Mn__RXHosCD7ueAbnUEafTqyLMPk8Um7oQO-8ScUTuazD4ERJEtcGO2b237784w482cutqRXjgra3_sr45gjfeUcZ6mv526TD1FFw9vm82qinblnNmxfCp6_MJIKuIgcyXdv2VB-0Foei9UYOEmSsfscljEu1qyOcUllRt7QPPlk6YxbgJyJMC9ziAFYFa9G1qNRf-h4JAiB9TgJEf4GWVSpHLtDbM4bCT8PaZap_P8Nw8XWRW3Z4q3SRmiaQGypHhSo9ti1XBQrX74umOVjO-S87vqY5UVxM9bE5FBcoPW62w8BMng9qsc10uJKSqbIOmzaiLyX9XvMuESs__-ohAng4uvjyXabCHZEImgneseHDchUnjwOOKbdNoPs4jt91oOGBb-PDGP-zgLhBPcyLEfXoEUH6u8WpF4f20k5ajpuEUD3KwIOdvBVT8-dbZ6D1acCpQXChOBmyd311o5uxvm9jkATfBzPZoX3jcYLBHw.bKPrmywT1AlvLGPRdKndJxITjZe-F8VRCrFybW5ZFbk
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: --> END GET
 
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: --> GET https://abc.monopoly.su/some-api/v1/items?Offset=0&Limit=30&Status=Archived
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: Authorization: Bearer eyJhbGciOiJBMjU2S1ciLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwidHlwIjoiSldUIn0.wFKgm2giYhvhHfWt2J_QNUu03fZincnCakk713hWGZzqiiA0mLK_NUFeT5JpZb0CYA5aoKoR83E3wf7FaewKb6tDK6PKsDmq.a17nh-pz2wbmIoRtihyXqw.0QhXtxmCaMeZm98C6XLV-uLMyr81D2uDuReC_P454HoGIeDQ1PmA5Jk7Ir0MsLljTQLXlAW_Bmzk9zwAno4NObLZLhAmmWuXWJlMswFG-1LOMLBHGmsaVy6NptHdQSNSAGKYj1zSDbltF2lBfiAYouj6ThcFOH9VdTfDjAmcacQmh3NhLRtcx6mrGcuGfRbmn2HfwnRqP1hZzlZQU9fsArFAkYZkpDOONYgfqrChOnSCx1at70Agu16JwUFBmxDDlJEqwZX73iutdZt2xqGw4d_tqOCyc90S5y4Abdf4t67RNJsotJ2RWnOKsbSDuJKnHuj6y5s8LBZR8SBU2WjvNoMmQ3KD8LAXRLmXM0jPW6F0IBy35tG75I0BJITbqxEWlCeGEkLEVK_UmX64FdrwdFS81vtdyeG-ZULLJr8eQi4Mn__RXHosCD7ueAbnUEafTqyLMPk8Um7oQO-8ScUTuazD4ERJEtcGO2b237784w482cutqRXjgra3_sr45gjfeUcZ6mv526TD1FFw9vm82qinblnNmxfCp6_MJIKuIgcyXdv2VB-0Foei9UYOEmSsfscljEu1qyOcUllRt7QPPlk6YxbgJyJMC9ziAFYFa9G1qNRf-h4JAiB9TgJEf4GWVSpHLtDbM4bCT8PaZap_P8Nw8XWRW3Z4q3SRmiaQGypHhSo9ti1XBQrX74umOVjO-S87vqY5UVxM9bE5FBcoPW62w8BMng9qsc10uJKSqbIOmzaiLyX9XvMuESs__-ohAng4uvjyXabCHZEImgneseHDchUnjwOOKbdNoPs4jt91oOGBb-PDGP-zgLhBPcyLEfXoEUH6u8WpF4f20k5ajpuEUD3KwIOdvBVT8-dbZ6D1acCpQXChOBmyd311o5uxvm9jkATfBzPZoX3jcYLBHw.bKPrmywT1AlvLGPRdKndJxITjZe-F8VRCrFybW5ZFbk
07-14 8:42:35.272 27598 27696 I okhttp.OkHttpClient: --> END GET
 
07-14 8:42:35.602 27598 27709 I okhttp.OkHttpClient: --> POST https://abc.monopoly.su/some-api/v1//auth/refresh
07-14 8:42:35.602 27598 27709 I okhttp.OkHttpClient: Content-Type: application/json; charset=UTF-8
07-14 8:42:35.602 27598 27709 I okhttp.OkHttpClient: Content-Length: 255
07-14 8:42:35.604 27598 27709 I okhttp.OkHttpClient: {"refreshToken":"JyP+J00ULCmCCoh/TqnbKtaxY0vQEKI4VlSgLfgAwOHmsVXtKhoXqlJNY81ByyHOqoFs51tUUEw9Uw9g44F5nSZe3/Um/3s8hC8TqTgpN8XrmwCIyDZqTG+3caSA4Pb82WksBGwwZJwTRTvGQ5AoIwH4lo+OvAy9HLyRdQ4jcqfS22I7NnbsLHJM5jfYzSa/Wd/HEUMg55bNRqZPxQDnFAmOPP0bh7y5vcvHWfAL/ck="}
07-14 8:42:35.604 27598 27709 I okhttp.OkHttpClient: --> END POST (255-byte body)
 
07-14 8:42:35.612 27598 27710 I okhttp.OkHttpClient: --> POST https://abc.monopoly.su/some-api/v1/auth/refresh
07-14 8:42:35.613 27598 27710 I okhttp.OkHttpClient: Content-Type: application/json; charset=UTF-8
07-14 8:42:35.614 27598 27710 I okhttp.OkHttpClient: Content-Length: 255
07-14 8:42:35.619 27598 27710 I okhttp.OkHttpClient: {"refreshToken":"JyP+J00ULCmCCoh/TqnbKtaxY0vQEKI4VlSgLfgAwOHmsVXtKhoXqlJNY81ByyHOqoFs51tUUEw9Uw9g44F5nSZe3/Um/3s8hC8TqTgpN8XrmwCIyDZqTG+3caSA4Pb82WksBGwwZJwTRTvGQ5AoIwH4lo+OvAy9HLyRdQ4jcqfS22I7NnbsLHJM5jfYzSa/Wd/HEUMg55bNRqZPxQDnFAmOPP0bh7y5vcvHWfAL/ck="}
07-14 8:42:35.619 27598 27710 I okhttp.OkHttpClient: --> END POST (255-byte body)
 
07-14 8:42:35.913 27598 27709 I okhttp.OkHttpClient: <-- 200 OK https://abc.monopoly.su/some-api/v1/auth/refresh (308ms)
07-14 8:42:35.913 27598 27709 I okhttp.OkHttpClient: Content-Type: application/json; charset=utf-8
07-14 8:42:35.913 28679 28880 I okhttp.OkHttpClient: {"userId":"dde85c6d-d1d2-47ba-ba7c-123124324","accessToken":{"token":"eyJhbGciOiJBMjU2S1ciLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwidHlwIjoiSldUIn0.1xwEBHrIaPZO6lumC6dvSeN-9PGlMWQGxcrop4ot-rDRB-vWt5cAbW5l9XooIXf9Njbn-ydv-7dYjxNuWxAkuyeowPte3giI.V80GULT8Tn_9uRXVs3jndw.Khuq6grvvqK5hXAFg5-YJGZ-HgjfuqQcC3DtlgwJqhqAPiLwDYLg4Fuil_3I1w2vyyp7i7rnMcXFORHMwhUmVFqkgF866ba9gDffsTaJNRtZLo7GL2a8IahcLmzXDp8RqQXRQ5BuiqEHC5Q5YGAsO_LwK0GC-JVY0NHRZeFSrJUTzQjoGRjSgY4_Yo8vERVkJ8KNE1lpHvt1XL1C2OiK8O0tYOkAQweI0Apvarf5m8BnEViSEHFYmfl_ugr-1iWTmPmIiueIwd_F8__ODiuuGuSWO4s6A4zPlieiEx2D3V5xRyaqAjVtSdglqmpy8F3MbBRi47UlW_-6Ge6HZmfAwkDC_Xdfe0GvUKKyoWjeWvfZJRYICWwhq5iNS18hDFv4ptnleGmSNsfwDWC1z0lCEhUvkzX5y3_gbdrEAc68HBxvHQ57yM28LlF7IID1N5zDV-sLeb5IFks46jsx7dEo6dTlwK-saMfVSpSxQF8K9DAZedE3PlPB1KkXTQTvechm7anHkoHWpA2bw5vrHzo8MPcphSG_tEaezmNfmnIz7GBMZe_AO_34eTbRCiu8Ixnho2zvqCzrQzjFlVB4Yf4p_WJxoSJU8IjWGd3-3XAjyJj8KbSkxiDb61sCCBq5Kz124Ck0MnHSCtfZ_ZM80XPWxpnre_2E9_RY2oYyxZsxWSwkw1IC4IJAmyEv42RzbJ9Vu0ali25KP6ddBShccnWGxg.hdsJHiMqXQrMgiNG5gXgPCmKqvcr-RJvvOdkmRoBTVY","validTo":"07-14 9:42:35.913"},"refreshToken":{"token":"/7L80kXH4wuTo/07ZYhe5Rx+M+f7jQRpGv/XHiHDmFPsPZcu2lwX48ab900R13QJku62sZa08Gq3gxilR0nsSUxg4EcmM7OFZgexa3LULyCxwclmTAOTDaPXltv96vM1mYZGA5CPyT1HGk0DLr2onF2zkBt+2yu4ALJwbNVzTFSVSz126KUbB1jsSSmHof9tQn8YnurJQ3N4nejAZ6UOpA==","validTo":"2022-07-25T15:10:54.5026581+03:00"}}
07-14 8:42:35.913 27598 27709 I okhttp.OkHttpClient: Transfer-Encoding: chunked
07-14 8:42:35.913 27598 27709 I okhttp.OkHttpClient: Connection: keep-alive
07-14 8:42:35.913 27598 27709 I okhttp.OkHttpClient: Vary: Accept-Encoding
07-14 8:42:35.917 27598 27709 I okhttp.OkHttpClient: <-- END HTTP (1574-byte body)
 
07-14 8:42:35.925 27598 27710 I okhttp.OkHttpClient: <-- 422 Unprocessable Entity https://abc.monopoly.su/some-api/v1/auth/refresh (305ms)
07-14 8:42:35.925 27598 27710 I okhttp.OkHttpClient: Content-Type: application/json; charset=utf-8
07-14 8:42:35.925 27598 27710 I okhttp.OkHttpClient: Content-Length: 331
07-14 8:42:35.926 27598 27710 I okhttp.OkHttpClient: Connection: keep-alive
07-14 8:42:35.928 27598 27710 I okhttp.OkHttpClient: <-- END HTTP (331-byte body)
```
