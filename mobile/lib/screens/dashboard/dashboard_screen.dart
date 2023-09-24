import 'package:faceverify/widgets/button.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class DashboardScreen extends StatelessWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text("Dashboard"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text("Dashboard de validação",
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.w600)),
            Button(
                text: "Navegar para home",
                onPressed: () {
                  context.go("/");
                })
          ],
        ),
      ),
    );
  }
}
